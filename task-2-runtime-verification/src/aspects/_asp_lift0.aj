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
before () : (call(* *.setFloor(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 130/*setFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 130/*setFloor*/);
}
}
before () : (call(* *.animateUp(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 122/*animateUp*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 122/*animateUp*/);
}
}
before () : (call(* *.moveLift(..)) && args(*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 134/*moveLift*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 134/*moveLift*/);
}
}
before () : (call(* *.animateDown(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 124/*animateDown*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 124/*animateDown*/);
}
}
before () : (call(* *.callLiftToFloor(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 132/*callLiftToFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 132/*callLiftToFloor*/);
}
}
before () : (call(* *.openDoors(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 128/*openDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 128/*openDoors*/);
}
}
before () : (call(* *.animateLiftMovement(..)) && args(*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 136/*animateLiftMovement*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 136/*animateLiftMovement*/);
}
}
before () : (call(* *.closeDoors(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 126/*closeDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 126/*closeDoors*/);
}
}
}