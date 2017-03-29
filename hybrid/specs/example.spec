Specification Heading
=====================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs

Employee details has Manager and Reportee details
-------------------------------------------------
* Open Employee Directory in web view
* Find employee "John Williams" with id "4"
* Verify the Manager "James King"
* Verify number of direct reports of employee with id "4" is "3"
* Verify the reportees of employee with id "4" are 

     |name        |
     |------------|
     |Paul Jones  |
     |Paula Gates |
     |Steven Wells|
