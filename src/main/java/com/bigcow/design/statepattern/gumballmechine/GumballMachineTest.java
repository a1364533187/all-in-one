package com.bigcow.design.statepattern.gumballmechine;

import com.bigcow.design.statepattern.gumballmechine.GumballMachine;

public class GumballMachineTest {

    public static void main(String[] args) {
        testGumballMachineDrive();
    }

    public static void testGumballMachineDrive() {
        //再来一次，让糖果机一开始就装了5颗糖果
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        //我们希望能赢，所以一直投钱并转动曲柄。
        //然后打印出糖果机的状态……
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
