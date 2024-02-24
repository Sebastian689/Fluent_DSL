package main.metamodel;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Transition{
	private String event;
	private State target;
	
	private String operationVariableName;
	private Integer operationValue;
	private OperationType operationType;
	
	private String conditionVariableName;
	private Integer conditionValue;
	private ComparisonType comparisonType;
	
	
	private enum OperationType { NONE, SET, INCREMENT, DECREMENT }
	public enum ComparisonType { EQUALS, GREATER, LESS }
	
	public Transition(String event) {
		this.event = event;
	}
	
	public String getEvent() {
		return event;
	}
	
	public void setTarget(State target) {
	    this.target = target;
	}

	public State getTarget() {
		return target;
	}
	
	
	public void setOperation(String name, int i) {
		this.operationVariableName = name;
		this.operationValue = i;
		this.operationType = OperationType.SET;
	}
	
	public void incrementOperation(String name) {
		this.operationVariableName = name;
	    this.operationType = OperationType.INCREMENT;
	}
	
	public void decrementOperation(String name) {
        this.operationVariableName = name;
        this.operationType = OperationType.DECREMENT;
    }

	public boolean hasSetOperation() {
		return this.operationType == OperationType.SET;
	}

	public boolean hasIncrementOperation() {
		return this.operationType == OperationType.INCREMENT;
	}

	public boolean hasDecrementOperation() {
		return this.operationType == OperationType.DECREMENT;
	}

	public String getOperationVariableName() {
		return this.operationVariableName;
	}
	
	public int getOperationValue() {
		return this.operationValue;
	}

	public boolean isConditional() {
		if (comparisonType != null) return true;
		return false;
	}
	
	public void setCondition(String name, int i) {
		this.conditionVariableName = name;
		this.conditionValue = i;
		this.comparisonType = ComparisonType.EQUALS;
	}
	
	public void greaterCondition(String name, int i) {
		this.conditionVariableName = name;
		this.conditionValue = i;
		this.comparisonType = ComparisonType.GREATER;
	}
	
	public void lessCondition(String name, int i) {
		this.conditionVariableName = name;
		this.conditionValue = i;
		this.comparisonType = ComparisonType.LESS;
	}
	
	public String getConditionVariableName() {
		return this.conditionVariableName;
	}
	
	public void setConditionVariableName(String name) {
		this.operationVariableName = name;
	}

	public Integer getConditionComparedValue() {
		return this.conditionValue;
	}

	public boolean isConditionEqual() {
		return this.comparisonType == ComparisonType.EQUALS;
	}

	public boolean isConditionGreaterThan() {
		return this.comparisonType == ComparisonType.GREATER;
	}

	public boolean isConditionLessThan() {
		return this.comparisonType == ComparisonType.LESS;
	}
	
	public ComparisonType comparisonType() {
		return comparisonType;
	}

	public boolean hasOperation() {
		if (operationType != null) return true;
		return false;
	}

}
