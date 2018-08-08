# MV

##REQUIREMENTS

* Oracle Java 9

##Using Fabric for deployment
Fabric is a Python library used to interact with SSH. This allows us to automate many tasks, deployment of out application is one of these.
Fabric scripts are basic Python files. They are run using the fab tool that is shipped with with Fabric.
The command to download it in ubuntu:
 - sudo apt-get install fabric
Or in windows, using pip:
 - pip install fabric
 
What Fabric really brings to the table is its extensive and excellent integration with SSH that allows streamlining everything using simple scripts (i.e. fabfile.py).

Fabric's run procedure is used for executing a shell command on one or more remote hosts. For example:

    - run("mkdir /tmp/trunk/")
 
In case we do not have the permissions we can use sudo command:

    - sudo("mkdir /var/www")
    - result = sudo("ls -l /var/www")
 
When you need to upload files, put command can be used:
 
    - put("/local/path/to/app.tar.gz", "/tmp/trunk/app.tar.gz")

This is an example of a fabfile.py used to upload an artifact and execute it in a remote server:

	from fabric.api import local, run, env, put
	import os, time
    # remote ssh credentials
	env.hosts = ['10.1.1.25']
	env.user = 'deploy'
	env.password = 'XXXXXXXX' #ssh password for user
	# or, specify path to server public key here:
	# env.key_filename = ''

	def deploy():
        # Temp file in remote server
        remote_tmp = '/tmp/example/'
        tag = datetime.now().strftime('%y.%m.%d_%H.%M.%S')
        run('rm -f %s' % remote_tmp)
        # Upload artifact to remote server
        put('quickstart-1.0.jar', remote_tmp)
        # Unpack
        remote_dist_dir = '/srv/www.example.com@%s' % tag
        remote_dist_link = '/srv/www.example.com'
        run('mkdir %s' % remote_dist_dir)
        with cd(remote_tmp):
            run('java -jar quickstart-1.0.jar')
        
With this file we only have to execute the following command to upload the artifact to remote server and install it:
    
    - fab deploy