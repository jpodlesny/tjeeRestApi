#!/bin/sh

echo "************ UNDEPLOYING *******************"
~/glassfish4/bin/asadmin undeploy szpitalRestApi
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
~/glassfish4/bin/asadmin deploy target/szpitalRestApi.war
