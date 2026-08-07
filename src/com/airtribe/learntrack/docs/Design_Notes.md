Design Notes

## Why ArrayList?

`ArrayList` is used for students, courses, and enrollments because the number of records is not known in
advance. Unlike an array, it grows as items are added while still allowing simple indexed iteration. 
It is an appropriate in-memory collection for this introductory application.

## Static members

`IdGenerator` has static counters and static methods because ID generation belongs to the application as
a whole, rather than to one particular student or course. A single counter per record type prevents 
duplicate IDs during one application run.

## Inheritance

`Student` extends `Person`, so both can share identity and contact fields. `Student` calls `super(...)` 
in its constructors and overrides `getDisplayName()`. This avoids duplicating common fields and 
demonstrates polymorphism: a `Student` can be treated as a `Person`.
