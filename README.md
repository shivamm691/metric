## System requirements:- 
_JDk 8 or above_.

_POSTMAN or ANY OTHER API testing Tool_



## Steps of Runing the server:

    **using docker imagefile**

   -  
    1. use flowing [link](https://hub.docker.com/repository/docker/shivamm691/metric) to accsee shivamm691/metric imgae.

     2.pull request to have a local copy of docker image or 
     [download](https://drive.google.com/drive/folders/1jvX93SPsvDHVItQue2y9wxbOGjDWpkBL) 
      
      2.start docker 

     
      3. use command to load image"docker image load <metric.tar"  to run docker image 
     
     ### use commad 
              `docker run -p8086:8086 metriccollector`
      
  
   


# Using spring tool suite  or any other ide(with spring tools support):
    1> download or clone files from git https://github.com/shivamm691/metric) to your local 
      repo or dir 

      2>install jdk8 or above in your system 
      
      3> open all file in ide 
      
      4> slect name of jrk file in target dir 
      
      5> open cmd/gitbash  to the current dir
      
      6>use command "java -jar <jar file name> " in cmd
      
      7>open postmen to check GET AND POST requset
      
      
      
      






#

exmaple port : 8086

1> POST request :

    Endpoint -/metric
   
   test case 1
   
    request body :
    {
    
    "data" : [1,2,3,4]
    
    }
    
    output
       1 
       explaination : 1 : successful data enter in database with current timestamp value : server return 1 as confirmation of database hasbeen update.   
    


  test case 2
   
    request body :
    {
    
    "data" : []
    
    }
    
    output
       0
       explaination : 0 means unsuccessful data enter or NULL data "0 " means no data enters in database 
    




1> GET request :

    Endpoint -/metric
   
   test case 1
   request parameters : time= "5m"
    
    
    output:
    x
     x=  sum of cumulation of all integer store in last 5 min


  test case 2
   
    request parameters time = "7m"
    
    output
       NONE
       explaination : since GET request should be in format of "5m" "10m" or "30m"
       no data response by server
