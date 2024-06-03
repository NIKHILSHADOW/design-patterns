## PROTOTYPE

- Two types

1. Simple Prototype
2. Prototype registry

### Simple Prototype

- create clone method for object creation.

- Used when instance creation is hard.

Why we need this?

For suppose converting field values to pixels is heavy task in graphics. So we create only once and reuse it for same type of object.

# Steps

1. Create a clonable interface with clone method
2. Create sub classes implementing clone method.
