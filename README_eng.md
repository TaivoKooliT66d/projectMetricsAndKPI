# projectMetricsAndKPI
http://kommuun.koodikool.ee/t/projekt-projekti-meetrikute-analuusimine-ja-statistika-kuvamine/206

# Introduction
I work as a software development program manager and I need constant overview where the program stands. Program is a set of projects which is managed by several project managers.

I have already defined datamodel for database and I will use for project plan importing MPJX library. Database initially created on TSQL, but for this project I will use most likely Maria DB.

# Purpose
Map down different metrics to review:

* Project health
* Find critical projects.
** Does it stick to deadline?
** How much buffer is left?
** Has the project progressed?
** How many tasks and defects are involved with some project.
** Manually created action item followups.
** Vacation database sync, if vacations are all represented in project plan.
** Compare diffs with issue tracking systems

# Technologies
* Java 8
* Tomcat 8 or Jetty
* Spring Framework
* If SQL queries will work and first iteration is done, then move to Hibernate.

# Outcome
* You can see project based bottlenecks fast.
*  People who don't need to read project plan, can see project health
* Business side gets more visiblity

# License
GNU General Public License
