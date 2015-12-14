#This page discusses about the design decisions about accessing data from front end.

# Introduction #
> //TODO write a introduction


# Methods #

## Use nodes directly from the front end ##

> Here we treat nodes as stateful resources, and do stateless operations on them. So we directly modify the nodes from front end. Advantage of this approach is that we can use full functionalities of JCR. This would increase the performance also as we are not coping data to copying data and creating additional business objects.
> Disadvantages are that front end coders will also have to know about the JCR API rather than using getters/setters. And also there may be a possibility that a technology used in the front end is powerful enough to manipulate JCR API.

**Example Link**

## Use business objects and delegate the persisting to jackrabbit-ocm ##
> Here we work with business objects and delegate the access to JCR content to the jackrabbit-ocm framework. We can work with POJOs and jackrabbit-ocm will persist them on JCR repository. Anyway we have to pre-configure the mapping between data bjects and Nodes in a mapping file. This will easy for the application programmers and make application layer independent of persistence Layer.

**Example Link**

## Wrap the nodes inside Wrapper classes ##
> This won’t be a good option as it we can do the same in a much easier way using jackrabbit-ocm.

**Example Link**


