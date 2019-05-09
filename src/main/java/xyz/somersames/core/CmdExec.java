package xyz.somersames.core;

public interface CmdExec {
    String execute(String type,String... args);

    String execute(String type);
}
