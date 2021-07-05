# Purpose of the project

This example will help you to configure a tier storage for your existing DHF. 
The trick is to create a partition with 0 forest, then rename the existing one to the standard format + assign the forests to it.

# Installation instruction 

## Deploy DataHub:
gradle mlDeploy

## Load Data with mlcp
gradle importContent

## execute workspace 
open the workspace named "tierStorageWorkspace.xml" and execute the steps in this order:

1. query assignment: change the final database assigment to query
2. default partition: create the default partition with 0 forests (you can change the partition name)
3. rename forests: rename the existing Final forest to hot-000*
4. set forests to partition 1: attach the forest to the default partition  
5. create tier1 partition: create the partition 2 with a forest folder
6. set query partition: set the query partition assiciated to the partition 2

## update gradle configuration
copy the folder : tierStorageGradleConf/ml-config to ml-config

## update the query partition
ml-gradle will not update the query partition if you change it directly in the project, you need first to delete the query partition with the admin rest api
