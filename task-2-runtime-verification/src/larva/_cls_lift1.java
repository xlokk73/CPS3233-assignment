package larva;


import com.liftmania.Lift;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_lift1 implements _callable{

public static LinkedHashMap<_cls_lift1,_cls_lift1> _cls_lift1_instances = new LinkedHashMap<_cls_lift1,_cls_lift1>();

_cls_lift0 parent;
public static boolean isMoving;
public static Lift l;
public Lift lift;
int no_automata = 2;
public Clock x = new Clock(this,"x");
public Clock y = new Clock(this,"y");

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_lift1( Lift lift) {
parent = _cls_lift0._get_cls_lift0_inst();
this.lift = lift;
}

public void initialisation() {
   x.reset();
   y.reset();
}

public static _cls_lift1 _get_cls_lift1_inst( Lift lift) { synchronized(_cls_lift1_instances){
_cls_lift1 _inst = new _cls_lift1( lift);
if (_cls_lift1_instances.containsKey(_inst))
{
_cls_lift1 tmp = _cls_lift1_instances.get(_inst);
 return _cls_lift1_instances.get(_inst);
}
else
{
 _inst.initialisation();
 _cls_lift1_instances.put(_inst,_inst);
 return _inst;
}
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_lift1)
 && (lift == null || lift.equals(((_cls_lift1)o).lift))
 && (parent == null || parent.equals(((_cls_lift1)o).parent)))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_lift1_instances){
_performLogic_LiftOpenTimeProperty(_info, _event);
_performLogic_StartMovingTimeProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_lift1[] a = new _cls_lift1[1];
synchronized(_cls_lift1_instances){
a = _cls_lift1_instances.keySet().toArray(a);}
for (_cls_lift1 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_lift1_instances){
_cls_lift1_instances.remove(this);}
synchronized(x){
x.off();
x._inst = null;
x = null;}
synchronized(y){
y.off();
y._inst = null;
y = null;}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_LiftOpenTimeProperty = 3;

public void _performLogic_LiftOpenTimeProperty(String _info, int... _event) {

_cls_lift0.pw.println("[LiftOpenTimeProperty]AUTOMATON::> LiftOpenTimeProperty("+lift + " " + ") STATE::>"+ _string_LiftOpenTimeProperty(_state_id_LiftOpenTimeProperty, 0));
_cls_lift0.pw.flush();

if (0==1){}
else if (_state_id_LiftOpenTimeProperty==1){
		if (1==0){}
		else if ((_occurredEvent(_event,2/*closeDoors*/)) && (y .compareTo (3 )<0 )){
		
		_state_id_LiftOpenTimeProperty = 3;//moving to state Idle
		_goto_LiftOpenTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,2/*closeDoors*/)) && (y .compareTo (3 )>=0 )){
		
		_state_id_LiftOpenTimeProperty = 0;//moving to state OpenTooLong
		_goto_LiftOpenTimeProperty(_info);
		}
}
else if (_state_id_LiftOpenTimeProperty==3){
		if (1==0){}
		else if ((_occurredEvent(_event,4/*openDoors*/))){
		y .reset ();

		_state_id_LiftOpenTimeProperty = 1;//moving to state Loading
		_goto_LiftOpenTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,0/*setMoving*/)) && (isMoving )){
		
		_state_id_LiftOpenTimeProperty = 2;//moving to state Moving
		_goto_LiftOpenTimeProperty(_info);
		}
}
else if (_state_id_LiftOpenTimeProperty==2){
		if (1==0){}
		else if ((_occurredEvent(_event,6/*setFloor*/))){
		
		_state_id_LiftOpenTimeProperty = 3;//moving to state Idle
		_goto_LiftOpenTimeProperty(_info);
		}
}
}

public void _goto_LiftOpenTimeProperty(String _info){
_cls_lift0.pw.println("[LiftOpenTimeProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_LiftOpenTimeProperty(_state_id_LiftOpenTimeProperty, 1));
_cls_lift0.pw.flush();
}

public String _string_LiftOpenTimeProperty(int _state_id, int _mode){
switch(_state_id){
case 1: if (_mode == 0) return "Loading"; else return "Loading";
case 2: if (_mode == 0) return "Moving"; else return "Moving";
case 3: if (_mode == 0) return "Idle"; else return "Idle";
case 0: if (_mode == 0) return "OpenTooLong"; else return "!!!SYSTEM REACHED BAD STATE!!! OpenTooLong "+new _BadStateExceptionlift().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_StartMovingTimeProperty = 9;

public void _performLogic_StartMovingTimeProperty(String _info, int... _event) {

_cls_lift0.pw.println("[StartMovingTimeProperty]AUTOMATON::> StartMovingTimeProperty("+lift + " " + ") STATE::>"+ _string_StartMovingTimeProperty(_state_id_StartMovingTimeProperty, 0));
_cls_lift0.pw.flush();

if (0==1){}
else if (_state_id_StartMovingTimeProperty==7){
		if (1==0){}
		else if ((_occurredEvent(_event,0/*setMoving*/)) && (isMoving &&x .compareTo (3 )<0 )){
		
		_state_id_StartMovingTimeProperty = 6;//moving to state Moving
		_goto_StartMovingTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,0/*setMoving*/)) && (isMoving &&x .compareTo (3 )>=0 )){
		
		_state_id_StartMovingTimeProperty = 4;//moving to state BadMoving
_cls_lift0.pw .println ("Oqqow!! lift took too long to start moving");

		_goto_StartMovingTimeProperty(_info);
		}
}
else if (_state_id_StartMovingTimeProperty==5){
		if (1==0){}
		else if ((_occurredEvent(_event,2/*closeDoors*/))){
		x .reset ();

		_state_id_StartMovingTimeProperty = 9;//moving to state Idle
		_goto_StartMovingTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,8/*callLiftToFloor*/))){
		
		_state_id_StartMovingTimeProperty = 8;//moving to state LoadingRequested
		_goto_StartMovingTimeProperty(_info);
		}
}
else if (_state_id_StartMovingTimeProperty==9){
		if (1==0){}
		else if ((_occurredEvent(_event,4/*openDoors*/))){
		
		_state_id_StartMovingTimeProperty = 5;//moving to state Loading
		_goto_StartMovingTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,8/*callLiftToFloor*/))){
		x .reset ();

		_state_id_StartMovingTimeProperty = 7;//moving to state Requested
		_goto_StartMovingTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,0/*setMoving*/)) && (isMoving )){
		
		_state_id_StartMovingTimeProperty = 6;//moving to state Moving
		_goto_StartMovingTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,4/*openDoors*/))){
		y .reset ();

		_state_id_StartMovingTimeProperty = 5;//moving to state Loading
		_goto_StartMovingTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,8/*callLiftToFloor*/))){
		x .reset ();

		_state_id_StartMovingTimeProperty = 7;//moving to state Requested
		_goto_StartMovingTimeProperty(_info);
		}
}
else if (_state_id_StartMovingTimeProperty==6){
		if (1==0){}
		else if ((_occurredEvent(_event,6/*setFloor*/))){
		x .reset ();

		_state_id_StartMovingTimeProperty = 9;//moving to state Idle
		_goto_StartMovingTimeProperty(_info);
		}
		else if ((_occurredEvent(_event,8/*callLiftToFloor*/))){
		
		_state_id_StartMovingTimeProperty = 8;//moving to state LoadingRequested
		_goto_StartMovingTimeProperty(_info);
		}
}
else if (_state_id_StartMovingTimeProperty==8){
		if (1==0){}
		else if ((_occurredEvent(_event,2/*closeDoors*/))){
		x .reset ();

		_state_id_StartMovingTimeProperty = 7;//moving to state Requested
		_goto_StartMovingTimeProperty(_info);
		}
}
}

public void _goto_StartMovingTimeProperty(String _info){
_cls_lift0.pw.println("[StartMovingTimeProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_StartMovingTimeProperty(_state_id_StartMovingTimeProperty, 1));
_cls_lift0.pw.flush();
}

public String _string_StartMovingTimeProperty(int _state_id, int _mode){
switch(_state_id){
case 7: if (_mode == 0) return "Requested"; else return "Requested";
case 5: if (_mode == 0) return "Loading"; else return "Loading";
case 6: if (_mode == 0) return "Moving"; else return "Moving";
case 9: if (_mode == 0) return "Idle"; else return "Idle";
case 8: if (_mode == 0) return "LoadingRequested"; else return "LoadingRequested";
case 4: if (_mode == 0) return "BadMoving"; else return "!!!SYSTEM REACHED BAD STATE!!! BadMoving "+new _BadStateExceptionlift().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}