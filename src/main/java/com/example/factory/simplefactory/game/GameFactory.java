package com.example.factory.simplefactory.game;

public class GameFactory {

    public static GameObject getInstance(GameType gameType) {

        switch (gameType) {
            case BACKGROUND: {
                return new BackGroundObj();
            }

            case FOREGROUND: {
                return new ForeGroundObj();
            }
        }

        throw new RuntimeException("Invalid gameType");
    }
}
