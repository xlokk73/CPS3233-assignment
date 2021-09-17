package com.liftmania;

import com.liftmania.states.LiftStates;
import junit.framework.Assert;
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


public class LiftTimeModel implements TimedFsmModel {

    //private LiftController liftController = new LiftController(6, 1, false);
    private LiftController liftController = new LiftController(5, 1, false);
    private LiftStates liftState = LiftStates.IDLE;
    private boolean isOpen = false;
    private boolean isMoving = false;
    private long startMoving = 0;
    private int currentFloor = 0;
    private int lastFloor = 0;
    private int lastDifferentFloor = 0;

    @Time public int time = 0;

    @Override
    public int getNextTimeIncrement(Random ran) {
        return 1;
    }

    @Override
    public Object getState() {
        return liftState;
    }

    @Override
    public void reset(boolean b) {
        if (b) {
            liftController = new LiftController(5, 1, false);
        }

        currentFloor = 0;
        liftState = LiftStates.IDLE;
        isOpen = false;
        isMoving = false;
    }

    public boolean openDoorGuard() { return getState().equals(LiftStates.IDLE);}
    public @Action void openDoor() {
        isOpen = true;

        liftState = LiftStates.LOADING;
    }

    public boolean closeDoorGuard() {return getState().equals(LiftStates.LOADING);}
    public @Action void closeDoor() {
        liftState = LiftStates.IDLE;
        isOpen = false;
    }

    public boolean moveLiftGuard() {return getState().equals(LiftStates.IDLE);}
    public @Action void moveLift() {
        liftState = LiftStates.MOVING;
        startMoving = System.currentTimeMillis();


        if (currentFloor == 0 ) {
            liftController.moveLift(0, 5);
        } else {
            liftController.moveLift(0, 0);
        }

        System.out.print("Time taken: ");
        System.out.println(System.currentTimeMillis() - startMoving);

        isMoving = true;
    }

    public boolean stopLiftGuard() {return getState().equals(LiftStates.MOVING);}
    public @Action void stopLift() {
        liftState = LiftStates.IDLE;
    }

    @Test
    public void main() throws FileNotFoundException {

        final TimedModel timedModel = new TimedModel(new LiftTimeModel());
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
