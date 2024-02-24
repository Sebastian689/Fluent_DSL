package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StateMachine {
	private Machine machine;
	private State currentState;
	private Transition currentTransition;
	
	public StateMachine() {
		this.machine = new Machine();
	}
	
	public Machine build() {
		if (machine.getInitialState() == null && !machine.getStates().isEmpty()) {
            machine.setInitialState(machine.getStates().get(0));
        }
		
		//currentState = null;
        //currentTransition = null;

        return machine;
	}

	public StateMachine state(String name) {
		currentState = machine.getState(name);
		if (currentState == null) {
			currentState = new State(name);
			machine.addState(currentState);
		}
		//System.out.println("In " + name);
		return this;
	}

	public StateMachine initial() {
		machine.setInitialState(currentState);
		return this;
	}

	public StateMachine when(String name) {
	    currentTransition = new Transition(name);
	    currentState.addTransition(currentTransition);
	    return this;
	}

	public StateMachine to(String targetName) {
	        State targetState = machine.getState(targetName);
	        if (targetState == null) {
	            targetState = new State(targetName);
	            machine.addState(targetState);
	        }
	        currentTransition.setTarget(targetState);
	        return this;
	}

	public StateMachine integer(String name) {
		machine.setInteger(name, 0);
		//currentTransition.setOperation(name, 0);
		return this;
	}

	public StateMachine set(String name, int i) {
		//machine.setInteger(name, i);
		currentTransition.setOperation(name, i);
		return this;
	}

	public StateMachine increment(String name) {
		currentTransition.incrementOperation(name);
        return this;
	}

	public StateMachine decrement(String name) {
		currentTransition.decrementOperation(name);
        return this;
	}

	public StateMachine ifEquals(String name, int i) {
		currentTransition.setCondition(name, i);
		return this;
	}

	public StateMachine ifGreaterThan(String name, int i) {
		currentTransition.greaterCondition(name, i);
		return this;
	}

	public StateMachine ifLessThan(String name, int i) {
		currentTransition.lessCondition(name, i);
		return this;
	}

}
