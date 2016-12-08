package ru.reeson2003.model.characters.creatures;


/**
 * Created by User on 12.11.2016.
 * фабрика выпускает конкретные фабрики параметров.
 */
public abstract class ParametersFactory {
    public abstract Parameters getParameters();

    public static ParametersFactory getPlayerParametersFactory(int str, int con, int agl, int wit, int itl, Experience exp) {
        return new PlayerParametersFactory(str, con, agl, wit, itl, exp);
    };
    public static Parameters getMonsterParameters(int id) {
        return null;
    };
}
