package test.java.com.liftmania;

import test.java.com.liftmania.states.LiftStates;
import junit.framework.Assert;
import main.java.com.liftmania.Lift;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.GraphListener;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import nz.ac.waikato.modeljunit.timing.Time;
import nz.ac.waikato.modeljunit.timing.TimedFsmModel;
import nz.ac.waikato.modeljunit.timing.TimedModel;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Random;


public class BasicLiftModel implements TimedFsmModel {

    private Lift lift = new Lift(0);
    private LiftStates liftState = LiftStates.IDLE;
    private boolean isOpen = false;
    private boolean isMoving = false;
    private int currentFloor = 0;
    private int lastFloor = 0;
    private int lastDifferentFloor = 0;

    @Time public int time = 0;

    @Override
    public int getNextTimeIncrement(Random ran) {
        return 1 + ran.nextInt(60);
    }

    @Override
    public Object getState() {
        return liftState;
    }

    @Override
    public void reset(boolean b) {
        if (b) {
            lift = new Lift(0);
        }
        currentFloor = 0;
        lastFloor = 0;
        lastDifferentFloor = 0;
        liftState = LiftStates.IDLE;
        isOpen = false;
        isMoving = false;
    }

    public boolean openDoorGuard() { return getState().equals(LiftStates.IDLE);}
    public @Action void openDoor() {
        isOpen = true;
        lastFloor = currentFloor;
        currentFloor = lift.floor;
        if (lastFloor != currentFloor) {
            lastDifferentFloor = lastFloor;
        }

        liftState = LiftStates.LOADING;
        lift.openDoors();

        Assert.assertEquals("Model does not match SUT: Doors", isOpen, lift.isOpen());
        Assert.assertFalse("Lift moved with door open!", lift.isMoving());
    }

    public boolean closeDoorGuard() {return getState().equals(LiftStates.LOADING);}
    public @Action void closeDoor() {
        liftState = LiftStates.IDLE;
        lift.closeDoors();

        isOpen = false;
        lastFloor = currentFloor;
        currentFloor = lift.floor;
        if (lastFloor != currentFloor) {
            lastDifferentFloor = lastFloor;
        }

        if (lift.isOpen()) {
            System.out.println("Lift is open before");
        } else {
            System.out.println("Lift is closed before");
        }

        Assert.assertEquals("Model does not match SUT: Doors", isOpen, lift.isOpen());
    }

    public boolean moveLiftGuard() {return getState().equals(LiftStates.IDLE);}
    public @Action void moveLift() {
        liftState = LiftStates.MOVING;
        lift.setMoving(true);

        isMoving = true;
        lastFloor = currentFloor;
        currentFloor = lift.floor;
        if (lastFloor != currentFloor) {
            lastDifferentFloor = lastFloor;
        }

        Assert.assertEquals("Model does not match SUT: Moving", isMoving, lift.isMoving());
        Assert.assertFalse("Moved with door open", lift.isOpen());
    }

    public boolean stopLiftGuard() {return getState().equals(LiftStates.MOVING);}
    public @Action void stopLift() {
        liftState = LiftStates.IDLE;
        lift.setMoving(false);

        lastFloor = currentFloor;
        currentFloor = lift.floor;
        if (lastFloor != currentFloor) {
            lastDifferentFloor = lastFloor;
        }

        Assert.assertFalse("Lift was moving with doors open", lift.isOpen());
    }

    @Test
    public void main() throws FileNotFoundException {

        final TimedModel timedModel = new TimedModel(new BasicLiftModel());
        timedModel.setTimeoutProbability(0.5);

        final GreedyTester tester = new GreedyTester(timedModel);
        tester.setRandom(new Random(2));
        tester.setResetProbability(0.1);

        final GraphListener graphListener = tester.buildGraph();
        graphListener.printGraphDot("/Users/manwel/Documents/School/cps3233/assignment/task-3-model-based-testing/LiftController/liftModelGraph.dot");

        tester.addListener(new StopOnFailureListener());
        tester.addListener("verbose");
        tester.addCoverageMetric(new TransitionPairCoverage());
        tester.addCoverageMetric(new TransitionCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric(new ActionCoverage());
        tester.generate(100);
        tester.printCoverage();
    }
}
