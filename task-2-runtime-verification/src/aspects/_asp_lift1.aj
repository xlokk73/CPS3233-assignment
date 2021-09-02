package aspects;

import larva.*;
public aspect _asp_lift1 {

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_lift1.initialize();
}
}
before ( boolean isMoving,Lift lift) : (call(* Lift.setMoving(..)) && target(lift) && args(isMoving) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift l;
l =lift ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( l);
_cls_inst.isMoving = isMoving;
_cls_inst.lift = lift;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 32/*setMoving*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 32/*setMoving*/);
}
}
before ( Lift lift) : (call(* Lift.openDoors(..)) && target(lift) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift l;
l =lift ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( l);
_cls_inst.lift = lift;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 36/*openDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 36/*openDoors*/);
}
}
before ( Lift lift) : (call(* Lift.setFloor(..)) && target(lift) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift l;
l =lift ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( l);
_cls_inst.lift = lift;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 38/*setFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 38/*setFloor*/);
}
}
before ( Lift lift) : (call(* Lift.closeDoors(..)) && target(lift) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift l;
l =lift ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( l);
_cls_inst.lift = lift;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 34/*closeDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 34/*closeDoors*/);
}
}
}