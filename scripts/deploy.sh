#!/bin/sh

echo "************ UNDEPLOYING *******************"
/opt/devel/glassfish4/bin/asadmin undeploy szpitalRestApi
echo "************ BUILDING **********************"
cd ..
mvn clean
mvn package
echo "************ DEPLOYING *********************"
/opt/devel/glassfish4/bin/asadmin deploy target/szpitalRestApi.war
