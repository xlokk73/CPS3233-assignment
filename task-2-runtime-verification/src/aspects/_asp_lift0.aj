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
before ( boolean moving) : (call(* *.setMoving(..)) && args(moving) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst.moving = moving;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 112/*setMoving*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 112/*setMoving*/);
}
}
before () : (call(* *.openDoors(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 116/*openDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 116/*openDoors*/);
}
}
before () : (call(* *.setFloor(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 118/*setFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 118/*setFloor*/);
}
}
before () : (call(* *.closeDoors(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){

_cls_lift0 _cls_inst = _cls_lift0._get_cls_lift0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 114/*closeDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 114/*closeDoors*/);
}
}
}