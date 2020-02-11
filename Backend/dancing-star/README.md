# Dancing Star Backend

### 1. Database - MongoDB

##### Collection - Dancing 

```json
{
  "id" : "Long",
  "title" : "String",
  "artist" : "String",
  "videoPath" : "String",
  "accuracySpots" : [{
    "id" : "Long",
    "time" : "String",
    "poseSpots" : [
      {
        "SPOT_TPYE" : "enum",
        "x" : "String",
        "y" : "String",
        "score" : "String"
      },
      {
        "SPOT_TPYE" : "enum",
        "x" : "String",
        "y" : "String",
        "score" : "String"
      },
      ...18개 좌표값
    ]},
    {
    "id" : "Long",
    "time" : "String",
    "poseSpots" : [
      {
        "SPOT_TPYE" : "enum",
        "x" : "String",
        "y" : "String",
        "score" : "String"
      },
      {
        "SPOT_TPYE" : "enum",
        "x" : "String",
        "y" : "String",
        "score" : "String"
      },
      ...18개 좌표값
    ]},
      ...초에 해당하는 좌표값들 ],
  "consistencySpots" : [ accuracySpots와 형식 동일 ]
}
```
##### Collection - Ranking

```json
{
  "id" : "Long",
  "dancingId" : "Long",
  "nickName" : "String",
  "userVideoPath" : "String",
  "registerTime" : "String",
  "faceScore" : "Integer",
  "gazeScore" : "Integer",
  "consistencyScore" : "Integer",
  "accuracyScore" : "Integer",
  "comboScore" : "Integer",
  "totalScore" : "Integer"
}
```


