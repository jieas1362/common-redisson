# redis - redisson

### application.yml
```
redisson:
  serverMode: SINGLE
  address: ******
  password:
  scanInterval: 8000
  checkSlotsCoverage: false
  tcpNoDelay: true
  masterConnectionMinimumIdleSize: 2
  slaveConnectionMinimumIdleSize: 2
  masterConnectionPoolSize: 2
  slaveConnectionPoolSize: 2
  subscriptionConnectionMinimumIdleSize: 2
  subscriptionConnectionPoolSize: 2
  subscriptionsPerConnection: 2
  subscriptionMode: MASTER
  timeout: 60000
  connectTimeout: 60000
  idleConnectionTimeout: 32000
  retryAttempts: 2
  retryInterval: 4000
  keepAlive: true
  dnsMonitoringInterval: -1
  pingConnectionInterval: 300000
  executorCorePoolSize: 4
  executorMaximumPoolSize: 8
  executorKeepAliveSeconds: 64
  executorBlockingQueueCapacity: 128
  maxTryLockWaitingMillis: 10000
```




### project
#### config class
```
@Component
@ConfigurationProperties(prefix = "redisson")
public class ProRedissonConfig extends BaseRedissonConfParams {

    @Override
    public LoadBalancer getLoadBalancer() {
        return new RoundRobinLoadBalancer();
    }

}
```


#### use1
```
    @Autowired
    private RedissonClient redissonClient;
```

#### use2
```
    @Autowired
    private SynchronizedProcessor synchronizedProcessor;

    synchronizedProcessor.handleTaskWithSync(key,task);
```