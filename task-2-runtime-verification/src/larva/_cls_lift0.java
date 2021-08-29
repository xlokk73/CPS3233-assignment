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
_performLogic_TimeProperties(_info, _event);
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

int _state_id_TimeProperties = 20;

public void _performLogic_TimeProperties(String _info, int... _event) {

_cls_lift0.pw.println("[TimeProperties]AUTOMATON::> TimeProperties("+") STATE::>"+ _string_TimeProperties(_state_id_TimeProperties, 0));
_cls_lift0.pw.flush();

if (0==1){}
else if (_state_id_TimeProperties==18){
		if (1==0){}
		else if ((_occurredEvent(_event,20/*setMoving*/)) && (moving ==true &&x .compareTo (3 )<0 )){
		
		_state_id_TimeProperties = 17;//moving to state Moving
		_goto_TimeProperties(_info);
		}
		else if ((_occurredEvent(_event,20/*setMoving*/)) && (moving ==true &&x .compareTo (3 )>=0 )){
		
		_state_id_TimeProperties = 15;//moving to state BadMoving
_cls_lift0.pw .println ("Oqqow!! lift took too long to start moving");

		_goto_TimeProperties(_info);
		}
}
else if (_state_id_TimeProperties==16){
		if (1==0){}
		else if ((_occurredEvent(_event,22/*closeDoors*/)) && (y .compareTo (3 )<0 )){
		x .reset ();

		_state_id_TimeProperties = 20;//moving to state Idle
		_goto_TimeProperties(_info);
		}
		else if ((_occurredEvent(_event,22/*closeDoors*/)) && (y .compareTo (3 )>=0 )){
		
		_state_id_TimeProperties = 14;//moving to state BadLoading
_cls_lift0.pw .println ("Oqqow!! lift open too long");

		_goto_TimeProperties(_info);
		}
		else if ((_occurredEvent(_event,28/*callLiftToFloor*/))){
		
		_state_id_TimeProperties = 19;//moving to state LoadingRequested
		_goto_TimeProperties(_info);
		}
}
else if (_state_id_TimeProperties==20){
		if (1==0){}
		else if ((_occurredEvent(_event,24/*openDoors*/))){
		y .reset ();

		_state_id_TimeProperties = 16;//moving to state Loading
		_goto_TimeProperties(_info);
		}
		else if ((_occurredEvent(_event,28/*callLiftToFloor*/))){
		x .reset ();

		_state_id_TimeProperties = 18;//moving to state Requested
		_goto_TimeProperties(_info);
		}
}
else if (_state_id_TimeProperties==17){
		if (1==0){}
		else if ((_occurredEvent(_event,26/*setFloor*/))){
		x .reset ();

		_state_id_TimeProperties = 20;//moving to state Idle
		_goto_TimeProperties(_info);
		}
		else if ((_occurredEvent(_event,28/*callLiftToFloor*/))){
		x .reset ();

		_state_id_TimeProperties = 18;//moving to state Requested
		_goto_TimeProperties(_info);
		}
}
else if (_state_id_TimeProperties==19){
		if (1==0){}
		else if ((_occurredEvent(_event,22/*closeDoors*/)) && (y .compareTo (3 )<0 )){
		x .reset ();

		_state_id_TimeProperties = 18;//moving to state Requested
		_goto_TimeProperties(_info);
		}
		else if ((_occurredEvent(_event,22/*closeDoors*/)) && (y .compareTo (3 )>=0 )){
		
		_state_id_TimeProperties = 14;//moving to state BadLoading
_cls_lift0.pw .println ("Oqqow!! lift open too long");

		_goto_TimeProperties(_info);
		}
}
}

public void _goto_TimeProperties(String _info){
_cls_lift0.pw.println("[TimeProperties]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_TimeProperties(_state_id_TimeProperties, 1));
_cls_lift0.pw.flush();
}

public String _string_TimeProperties(int _state_id, int _mode){
switch(_state_id){
case 18: if (_mode == 0) return "Requested"; else return "Requested";
case 16: if (_mode == 0) return "Loading"; else return "Loading";
case 17: if (_mode == 0) return "Moving"; else return "Moving";
case 20: if (_mode == 0) return "Idle"; else return "Idle";
case 19: if (_mode == 0) return "LoadingRequested"; else return "LoadingRequested";
case 14: if (_mode == 0) return "BadLoading"; else return "!!!SYSTEM REACHED BAD STATE!!! BadLoading "+new _BadStateExceptionlift().toString()+" ";
case 15: if (_mode == 0) return "BadMoving"; else return "!!!SYSTEM REACHED BAD STATE!!! BadMoving "+new _BadStateExceptionlift().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}