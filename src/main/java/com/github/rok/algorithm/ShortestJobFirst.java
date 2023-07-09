package com.github.rok.algorithm;

import com.github.rok.interfaces.IMainController;
import com.github.rok.interfaces.AlgorithmInterface;
import com.github.rok.os.Process;

/*
 * @author Fantiko, Kaio Stefan Campos Nunes created on 07/07/2023
 */
public class ShortestJobFirst implements AlgorithmInterface{

    private final IMainController controller;

    public ShortestJobFirst(IMainController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        Process lowestSizeProcess = controller.getIMemory().getLowestTimeProcess();
        if (lowestSizeProcess == null) {
            return;
        }
        controller.addProcessToCPU(lowestSizeProcess, lowestSizeProcess.getWaitingTime()/2);
    }
}