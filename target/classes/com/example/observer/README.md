# OBSERVER

[Home](../../../../../../README.md)

## Contents

- [OBSERVER](#observer)
  - [Contents](#contents)
    - [Introduction](#introduction)
    - [Steps](#steps)
    - [Code](#code)

### Introduction

It Says **Define a one-to-many dependency between objects so that when one
object changes state, all its dependents are notified and updated automatically.**

Let's suppose consider a bitcoin class where if bitcoin price changes, we need to be notified.

For suppose let's try polling
if we keep on getting bitcoin price and if changes with prev value, we will notify, but the problems are

1. When to getPrice(interval between curr and next)
2. how to notify.

### Steps

1. create Observer interface with notify method.
2. create observable (publisher) abstract class with list observers.
3. create concrete observable class with bitcoin as dependency and event(reason to notify).
4. create concrete observers

### Code

```java
// Step 1.

public interface Observer {

    public void notifyChange();

}


// Step 2.


public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.notifyChange();
        }
    }
}

// Step 3.

@AllArgsConstructor
public class BitcoinManager extends Observable {
    private Bitcoin bitcoin;

    public void setPrice(Double price) {
        if (bitcoin.getPrice().equals(price)) {
            return;
        }
        bitcoin.setPrice(price);
        notifyObservers();
    }
}


// Step 4.

public class EmailNotifier implements Observer {

    @Override
    public void notifyChange() {
        System.out.println("sending Email...!");
    }

}


```
