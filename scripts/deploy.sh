#!/bin/sh

echo "************ UNDEPLOYING *******************"
/opt/devel/glassfish4/bin/asadmin undeploy szpitalRestApi-1
echo "************ BUILDING **********************"
cd ..
mvn clean
mvn package
echo "************ DEPLOYING *********************"
/opt/devel/glassfish4/bin/asadmin deploy target/szpitalRestApi-1.war
