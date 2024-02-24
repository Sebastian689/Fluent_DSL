package main.metamodel;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Machine {
	private List<State> states = new ArrayList<>();
	private State initialState;
	private Map<String, Integer> integers = new HashMap<>();
	
	public void addState(State state) {
		states.add(state);
	}

	public List<State> getStates() {
		return states;
	}
	
	public void setInitialState(State state) {
        this.initialState = state;
    }

	public State getInitialState() {
		return initialState;
	}

	public State getState(String name) {
		for (State state : states) {
	        if (state.getName().equals(name)) {
	            return state;
	        }
	    }

	    return null;
	}
	
	public void setInteger(String name, int value) {
		integers.put(name, value);
	}
	
	public int getInt(String name) {
		Integer value = integers.get(name);
		if (value != null) {
			return value;
		}
		System.out.println("Didn't find int");
		return 0;
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String name) {
		for (String key : integers.keySet()) {
		    if (key.equals(name)) {
		        return true;
		    }
		}
		return false;
	}
}

