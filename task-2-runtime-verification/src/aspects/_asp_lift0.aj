package aspects;

import larva.*;
public aspect _asp_lift0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_lift0.initialize();
}
}
before ( boolean isMoving) : (call(* *.setMoving(..)) && args(isMoving) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst.isMoving = isMoving;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 220/*setMoving*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 220/*setMoving*/);
}
}
before () : (call(* *.setFloor(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 226/*setFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 226/*setFloor*/);
}
}
before () : (call(* *.animateUp(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 216/*animateUp*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 216/*animateUp*/);
}
}
before () : (call(* *.animateDown(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 218/*animateDown*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 218/*animateDown*/);
}
}
before () : (call(* *.callLiftToFloor(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 228/*callLiftToFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 228/*callLiftToFloor*/);
}
}
before () : (call(* *.openDoors(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 224/*openDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 224/*openDoors*/);
}
}
before () : (call(* *.closeDoors(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 222/*closeDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 222/*closeDoors*/);
}
}
}