package aspects;

import main.java.com.liftmania.Lift;

import larva.*;
public aspect _asp_lift1 {

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_lift1.initialize();
}
}
before ( boolean isMoving,Lift l) : (call(* Lift.setMoving(..)) && target(l) && args(isMoving) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift lift;
lift =l ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( lift);
_cls_inst.isMoving = isMoving;
_cls_inst.l = l;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 20/*setMoving*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 20/*setMoving*/);
}
}
before ( Lift l) : (call(* Lift.openDoors(..)) && target(l) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift lift;
lift =l ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( lift);
_cls_inst.l = l;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 24/*openDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 24/*openDoors*/);
}
}
before ( Lift l) : (call(* Lift.setFloor(..)) && target(l) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift lift;
lift =l ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( lift);
_cls_inst.l = l;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 26/*setFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 26/*setFloor*/);
}
}
after () returning (Lift l) : (call(* *.callLiftToFloor(..)) && args(*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift lift;
lift =l ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( lift);
_cls_inst.l = l;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 28/*callLiftToFloor*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 28/*callLiftToFloor*/);
}
}
before ( Lift l) : (call(* Lift.closeDoors(..)) && target(l) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_lift0.lock){
Lift lift;
lift =l ;

_cls_lift1 _cls_inst = _cls_lift1._get_cls_lift1_inst( lift);
_cls_inst.l = l;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 22/*closeDoors*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 22/*closeDoors*/);
}
}
}