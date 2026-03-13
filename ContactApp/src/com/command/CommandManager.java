package com.command;

import java.util.Stack;

public class CommandManager {

    private Stack<ContactCommand> undoStack = new Stack<>();
    private Stack<ContactCommand> redoStack = new Stack<>();

    public void executeCommand(ContactCommand command) {

        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {

        if (!undoStack.isEmpty()) {

            ContactCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {

        if (!redoStack.isEmpty()) {

            ContactCommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}