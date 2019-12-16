
W  A  V  E  S      F X

Advanced 2D Simulator for Harmonical Waves 

Copyright (c) 2019 M. Toledo Gonzalez

License GPL v3 - Free Software Foundation -

Programmed in Java (TM) 


* SYNOPSIS

WavesFX is a Java FX application to compute and represent with
a very high precision harmonical waves evolving in space and time.

The real-time motor is result of many years of investigation 
about the nature of the time. I decided to implement the 
philosophical motor in Java because of the cross-platform
nature of the language.

Some of the "normal" features are XY scalation, manual 
or mouse-assisted, translation of the XY axes, change of
background colors, dynamic range X and DX, etc.

The program is bi-threaded at run-time with 2 cooperative
threads: background + foreground, that allows that all
user-input parameters (including change of the virtual-time!)
are automatically updated at run-time.

For experts only: the "trick" consist basically on the
fabrication of a parameter "k" controlling "foreground" update
in terms of the "background" update ratio, respect to
a mathematical modular relation real/virtual time.
These threads are implemented in Java FX with time-lines classes.

* WHERE GOING BEYOND ?

Despite of the synchronization parameter "k" can solve
many performance problems, the hardware itself has its
limitations when the waves include more than 900 particles
evolving simultaneously. From my experience Java FX offers
more performance at run-time as Swing. A new implementation
of the motor using the .NET technology with
its DirectX integration could be considered, in
the hope that normal computers reach at least simulations
with 10,000 particles.

Well, maybe we should try...


---

Miguel Toledo Gonzalez

16.12.2019dC, Dörpen - GERMANY























