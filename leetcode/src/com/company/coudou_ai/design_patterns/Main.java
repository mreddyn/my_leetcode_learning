package com.company.coudou_ai.design_patterns;

import java.util.Scanner;

// Declare the EnemyFactory class and Enemy-related methods
// (User will implement these classes and methods)

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        // Input: Difficulty level
        String difficulty = sc.next();

        EnemyFactory enemyFactory = new Main().new EnemyFactory();

        // Call the user's factory method to create the enemy
        Enemy enemy = enemyFactory.createEnemy(difficulty);

        // Output in the specified format
        if (enemy != null) {
            System.out.println("Enemy Type: " + enemy.getType());
            System.out.println("Health: " + enemy.getHealth());
            System.out.println("Speed: " + enemy.getSpeed() + ", Attack Power: " + enemy.getAttackPower());
        }
        sc.close();
    }

    abstract class Enemy {
        final String type;
        final int health;
        final int speed;
        final int attackPower;

        Enemy(String type, int health, int speed, int attackPower) {
            this.type = type;
            this.health = health;
            this.speed = speed;
            this.attackPower = attackPower;
        }

        String getType() {
            return this.type;
        }

        int getHealth() {
            return this.health;
        }

        int getSpeed() {
            return this.speed;
        }

        int getAttackPower() {
            return this.attackPower;
        }
    }

    class Zombie extends Enemy {
        Zombie() {
            super("Zombie", 50, 2, 10);
        }
    }

    class Vampire extends Enemy {
        Vampire() {
            super("Vampire", 30, 4, 15);
        }
    }

    class Werewolf extends Enemy {
        Werewolf() {
            super("Werewolf", 80, 6, 25);
        }
    }

    class EnemyFactory {
        Enemy createEnemy(String difficulty) {
            if (difficulty == null) {
                throw new IllegalArgumentException("Difficulty level cannot be null");
            }
            if (difficulty.isEmpty()) {
                throw new IllegalArgumentException("Difficulty level cannot be empty");
            }

            switch (difficulty) {
                case "EASY":
                    return new Zombie();
                case "MEDIUM":
                    return new Vampire();
                case "HARD":
                    return new Werewolf();
                default:
                    throw new IllegalArgumentException("Unknown difficulty level " + difficulty);
            }
        }
    }
}
