package com.bigcow.design.statepattern.circuitbreaker;

public class TestCircuitBreakerMachineDriver {

    public static void main(String[] args) {
        CircuitBreakerMachine circuitBreakerMachine = new CircuitBreakerMachine(StateEnum.CLOSED);
        circuitBreakerMachine.transClosedToOpen();
        System.out.println(circuitBreakerMachine);
        circuitBreakerMachine.transOpenToHalfOpen();
        System.out.println(circuitBreakerMachine);
        circuitBreakerMachine.transHalfOpenToOpen();
        System.out.println(circuitBreakerMachine);
        circuitBreakerMachine.transOpenToHalfOpen();
        System.out.println(circuitBreakerMachine);
        circuitBreakerMachine.transOpenToHalfOpen();
        System.out.println(circuitBreakerMachine);
        circuitBreakerMachine.transHalfOpenToClosed();
        System.out.println(circuitBreakerMachine);
        circuitBreakerMachine.transOpenToHalfOpen();

    }
}
