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
before () : (call(* *.openLiftDoor(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 116/*openLiftDoor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 116/*openLiftDoor*/);
}
}
before () : (call(* *.moveLift(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 112/*moveLift*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 112/*moveLift*/);
}
}
before () : (call(* *.callLiftToFloor(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 118/*callLiftToFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 118/*callLiftToFloor*/);
}
}
before () : (call(* *.closeLiftDoor(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 114/*closeLiftDoor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 114/*closeLiftDoor*/);
}
}
}