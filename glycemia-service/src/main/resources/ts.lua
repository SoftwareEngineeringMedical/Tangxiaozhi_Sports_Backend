-- Redis TimeSeries
local user_key=KEYS[1]
local timestamp=ARGV[1]
local glycemia_value=ARGV[2]
local existed=redis.call('EXISTS',user_key)
local last_char = user_key:sub(-1)
if existed==0 then
    redis.call('TS.CREATE',user_key,'RETENTION',31536000000)
end
if existed==0 and tonumber(last_char) ~= nil then
    redis.call('TS.CREATE',user_key..':avg','RETENTION',31536000000)
    redis.call('TS.CREATE',user_key..':max','RETENTION',31536000000)
    redis.call('TS.CREATE',user_key..':min','RETENTION',31536000000)
    redis.call('TS.CREATERULE',user_key,user_key..':avg','AGGREGATION','AVG','86400000')
    redis.call('TS.CREATERULE',user_key,user_key..':max','AGGREGATION','MAX','86400000')
    redis.call('TS.CREATERULE',user_key,user_key..':min','AGGREGATION','MIN','86400000')
end
local existing=redis.call('TS.RANGE', user_key, timestamp,timestamp)
if existing~=nil and #existing==0 then
    redis.call('TS.ADD',user_key,timestamp,glycemia_value)
end

