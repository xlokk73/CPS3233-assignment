package com.uom.cps3225.gui;

public class AnimationCommand {
	
	public static enum Command {move, open, close, call};
	
	public Command command;
	public int toFloor;
	
	public AnimationCommand(Command command, int toFloor) {
		this.command = command;
		this.toFloor = toFloor;
	}
	
}
