# address

仅限中国地区的三或四级联动地址服务（采用淘宝网地址选择器中国地址库地址信息），顶级(0)为中国，一级(1)为省级/省级行政区，二级(2)为市级，三级(3)为区/县，四级(4)为街道级别。

# build 

使用 gradle构建,默认端口 8080

# using
配置文件 datasource.properties中该为自己的数据库连接，和redis(cache)连接即可。
```bash
gradle build
# 在 ${projectHome}/build/libs/ 路径下找到 address-1.0.jar,执行:
java -jar address-1.0.jar
```

# dependencies

- spring-boot
- mybatis
- fastjson
- httpclient

# RESTful

## 获取国家/地区列表
http://host:port/address/countries


## 四级地址服务
GET/ http://host:port/address/areas?areaCode={areaCode}&children={true|false}
>参数可都为空
>@param areaCode 地址编号
>@param children(default:true) 为请求是否包含下级地址列表

示例: GET/ http://localhost:8080/address/areas
```json
{
    "areaCode":"1",
    "name":"中国",
    "aliaName":"中国",
    "parentCode":"0",
    "level":0,
    "type":0,
    "children":[
        {
            "areaCode":"110000",
            "name":"北京",
            "aliaName":"北京",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"120000",
            "name":"天津",
            "aliaName":"天津",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"650000",
            "name":"新疆",
            "aliaName":"新疆",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"540000",
            "name":"西藏",
            "aliaName":"西藏",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"530000",
            "name":"云南",
            "aliaName":"雲南",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"330000",
            "name":"浙江",
            "aliaName":"浙江",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"210000",
            "name":"辽宁",
            "aliaName":"遼寧",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"150000",
            "name":"内蒙古",
            "aliaName":"內蒙古",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"640000",
            "name":"宁夏",
            "aliaName":"寧夏",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"630000",
            "name":"青海",
            "aliaName":"青海",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"370000",
            "name":"山东",
            "aliaName":"山東",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"310000",
            "name":"上海",
            "aliaName":"上海",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"140000",
            "name":"山西",
            "aliaName":"山西",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"610000",
            "name":"陕西",
            "aliaName":"陝西",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"510000",
            "name":"四川",
            "aliaName":"四川",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"460000",
            "name":"海南",
            "aliaName":"海南",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"130000",
            "name":"河北",
            "aliaName":"河北",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"230000",
            "name":"黑龙江",
            "aliaName":"黑龍江",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"410000",
            "name":"河南",
            "aliaName":"河南",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"420000",
            "name":"湖北",
            "aliaName":"湖北",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"430000",
            "name":"湖南",
            "aliaName":"湖南",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"320000",
            "name":"江苏",
            "aliaName":"江蘇",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"360000",
            "name":"江西",
            "aliaName":"江西",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"220000",
            "name":"吉林",
            "aliaName":"吉林",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"340000",
            "name":"安徽",
            "aliaName":"安徽",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"500000",
            "name":"重庆",
            "aliaName":"重慶",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"350000",
            "name":"福建",
            "aliaName":"福建",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"620000",
            "name":"甘肃",
            "aliaName":"甘肅",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"440000",
            "name":"广东",
            "aliaName":"廣東",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"450000",
            "name":"广西",
            "aliaName":"廣西",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"520000",
            "name":"贵州",
            "aliaName":"貴州",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"810000",
            "name":"香港",
            "aliaName":"香港",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        },
        {
            "areaCode":"820000",
            "name":"澳门",
            "aliaName":"澳門",
            "parentCode":"1",
            "level":1,
            "type":0,
            "children":null
        }
    ]
}
```

# data
[/sql](/sql "area.sql & area.csv")
