# This page describes about the node structure of the jackrabbit-jcr-demo application

# Introduction #
> When building a application on top of Jackrabbit, defining the node structure and custom node types plays a major role.

# Custom Node Types #

CND Notation

```

<blog = ' http://jackrabbit.apache.org/jackrabbit-jcr-demo/1.0'>
<mix = 'http://www.jcp.org/jcr/mix/1.0' >
<nt = ' http://www.jcp.org/jcr/nt/1.0'>

[blog:user] >  nt:folder, mix:referenceable                  
- blog:nickname  (string) mandatory
- blog:email  (string) mandatory
- blog:password (string) mandatory


[blog:blogEntry] > nt:folder, mix:referenceable
- blog:title (string) mandarory primary
- blog:content (string) mandatory
- blog:rate (long)
- blog:created (date) autocreated
- blog:published (date)
- blog:updated (date)


[blog:comment] > nt:hierarchyNode
- blog:content (string) mandatory primary
- blog:commenter (reference ) mandatory  < blog:user

```

# Node Structure #

```

/blogRoot [nt:folder]
/blogRoot/user [blog:user]
/blogRoot/user/<yyyy> [nt:folder]
/blogRoot/user/<yyyy>/<mm> [nt:folder]
/blogRoot/user/<yyyy>/<mm>/blogEntry [blog:blogEntry]
/blogRoot/user/<yyyy>/<mm>/blogEntry/comment [blog:Comment]
/blogRoot/user/avatar [nt:file]
/<libray> [nt:folder]

```


# Lessons learned #