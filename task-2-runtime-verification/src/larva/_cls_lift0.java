package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_lift0 implements _callable{

public static PrintWriter pw; 
public static _cls_lift0 root;

public static LinkedHashMap<_cls_lift0,_cls_lift0> _cls_lift0_instances = new LinkedHashMap<_cls_lift0,_cls_lift0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("/Users/manwel/Documents/School/cps3233/assignment/task-2-runtime-verification/src/output_lift.txt");

root = new _cls_lift0();
_cls_lift0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_lift0 parent; //to remain null - this class does not have a parent!
public static boolean moving;
int no_automata = 1;
public Clock x = new Clock(this,"x");
public Clock y = new Clock(this,"y");

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_lift0() {
}

public void initialisation() {
   x.reset();
   y.reset();
}

public static _cls_lift0 _get_cls_lift0_inst() { synchronized(_cls_lift0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_lift0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_lift0_instances){
_performLogic_AutomaticDoorClose(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_lift0[] a = new _cls_lift0[1];
synchronized(_cls_lift0_instances){
a = _cls_lift0_instances.keySet().toArray(a);}
for (_cls_lift0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_lift0_instances){
_cls_lift0_instances.remove(this);}
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

int _state_id_AutomaticDoorClose = 63;

public void _performLogic_AutomaticDoorClose(String _info, int... _event) {

_cls_lift0.pw.println("[AutomaticDoorClose]AUTOMATON::> AutomaticDoorClose("+") STATE::>"+ _string_AutomaticDoorClose(_state_id_AutomaticDoorClose, 0));
_cls_lift0.pw.flush();

if (0==1){}
else if (_state_id_AutomaticDoorClose==61){
		if (1==0){}
		else if ((_occurredEvent(_event,90/*closeDoors*/))){
		x .reset ();

		_state_id_AutomaticDoorClose = 63;//moving to state Idle
		_goto_AutomaticDoorClose(_info);
		}
}
else if (_state_id_AutomaticDoorClose==63){
		if (1==0){}
		else if ((_occurredEvent(_event,92/*openDoors*/))){
		y .reset ();

		_state_id_AutomaticDoorClose = 61;//moving to state Loading
		_goto_AutomaticDoorClose(_info);
		}
		else if ((_occurredEvent(_event,88/*setMoving*/)) && (moving ==true )){
		y .reset ();

		_state_id_AutomaticDoorClose = 62;//moving to state Moving
		_goto_AutomaticDoorClose(_info);
		}
}
else if (_state_id_AutomaticDoorClose==62){
		if (1==0){}
		else if ((_occurredEvent(_event,88/*setMoving*/)) && (moving ==false )){
		x .reset ();

		_state_id_AutomaticDoorClose = 63;//moving to state Idle
		_goto_AutomaticDoorClose(_info);
		}
}
}

public void _goto_AutomaticDoorClose(String _info){
_cls_lift0.pw.println("[AutomaticDoorClose]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_AutomaticDoorClose(_state_id_AutomaticDoorClose, 1));
_cls_lift0.pw.flush();
}

public String _string_AutomaticDoorClose(int _state_id, int _mode){
switch(_state_id){
case 60: if (_mode == 0) return "DoorOpenTooLong"; else return "!!!SYSTEM REACHED BAD STATE!!! DoorOpenTooLong "+new _BadStateExceptionlift().toString()+" ";
case 61: if (_mode == 0) return "Loading"; else return "Loading";
case 62: if (_mode == 0) return "Moving"; else return "Moving";
case 63: if (_mode == 0) return "Idle"; else return "Idle";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}