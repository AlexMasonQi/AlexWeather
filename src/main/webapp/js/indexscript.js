$(function ()
{
    $("#submitbtn").click(function ()
    {
        var url = "/AlexWeather/current/query";
        var text = document.getElementsByClassName("res")[0].innerHTML;
        var arr=text.split(" ---- ");
        var queryStr=arr[0]+":"+$("#inputCity").val();

        if (queryStr !== null && queryStr !== "")
        {
            var param = {city: queryStr};
            $.post(url, param, function (result)
            {
                $(".show-weather").show();
                $(".pro-city").html(result.provience+"&nbsp;&nbsp;"+result.cityName);
                var weatherInfo=result.weather;
                switch(weatherInfo)
                {
                    case "晴":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_0.gif");
                    }break;

                    case "多云":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_1.gif");
                    }break;

                    case "阴":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_2.gif");
                    }break;

                    case "阵雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_3.gif");
                    }break;

                    case "雷阵雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_4.gif");
                    }break;

                    case "雷阵雨并伴有冰雹":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_5.gif");
                    }break;

                    case "雨夹雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_6.gif");
                    }break;

                    case "小雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_7.gif");
                    }break;

                    case "中雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_8.gif");
                    }break;

                    case "大雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_9.gif");
                    }break;

                    case "暴雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_10.gif");
                    }break;

                    case "大暴雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_11.gif");
                    }break;

                    case "特大暴雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_12.gif");
                    }break;

                    case "阵雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_13.gif");
                    }break;

                    case "小雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_14.gif");
                    }break;

                    case "中雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_15.gif");
                    }break;

                    case "大雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_16.gif");
                    }break;

                    case "暴雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_17.gif");
                    }break;

                    case "雾":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_18.gif");
                    }break;

                    case "冻雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_19.gif");
                    }break;

                    case "沙尘暴":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_20.gif");
                    }break;

                    case "小雨-中雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_21.gif");
                    }break;

                    case "中雨-大雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_22.gif");
                    }break;

                    case "大雨-暴雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_23.gif");
                    }break;

                    case "暴雨-大暴雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_24.gif");
                    }break;

                    case "大暴雨-特大暴雨":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_25.gif");
                    }break;

                    case "小雪-中雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_26.gif");
                    }break;

                    case "中雪-大雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_27.gif");
                    }break;

                    case "大雪-暴雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_28.gif");
                    }break;

                    case "浮尘":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_29.gif");
                    }break;

                    case "扬沙":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_30.gif");
                    }break;

                    case "强沙尘暴":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_31.gif");
                    }break;

                    case "飑":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_32.gif");
                    }break;

                    case "龙卷风":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_33.gif");
                    }break;

                    case "弱高吹雪":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_34.gif");
                    }break;

                    case "轻雾":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_35.gif");
                    }break;

                    case "霾":
                    {
                        $(".weather-image").attr("src","/AlexWeather/icons/a_18.gif");
                    }break;
                }
                $(".temperature").text(result.temperature+" ℃")
                $(".weather1").text(weatherInfo);
                $(".last-update-time").text("最后更新时间："+result.reportTime);
                $(".win-direction").text("风向："+result.windDir+"风");
                $(".wind-speed").text("风速："+result.windPower+"级");
                $(".humidity").text("湿度："+result.humidity);
            }, "json");
        }
    });

    $('#inputCity').focus(function ()
    {
        $('.select_box').show();
    });

    $('#inputCity').click(function (e)
    {
        e.stopPropagation();
    });

    $('.select_box').click(function (e)
    {
        e.stopPropagation();
    });

    $(document).click(function ()
    {
        $('.select_box').hide();
    });

    $('.com-region').click(function ()
    {
        $('.select_list1').hide();
        $('.select_list2').show();

        var text=$(this).text();
        var proParam={provience:text};
        var url="/AlexWeather/current/selectcity";

        $.post(url,proParam,function(result)
        {
            $(".proName").text(proParam.provience+"地区");

            var str="";

            $(result).each(function(index,value)
            {
                str=str+"<li class='list-inline-item'><a href='#' class='com-city' value='"+value.citycode+"'>"+value.city+"</a></li>";
            });
            $(".city-list").html(str);
        },"json");
    });

    $('.select_list2 .back').click(function ()
    {
        $('.select_list2').hide();
        $('.select_list1').show();
    });

});

function listenText()
{
    var url="/AlexWeather/current/search";
    var str=$("input[type='text']").val();
    var param={inputValue:str};

    if(str==="" || str===null)
    {
        $(".select_list1").show();
        $(".select-query").hide();
    }
    else
    {
        $.post(url,param,function(result)
        {
            $(".select_list1").hide();
            $(".select-list2").hide();
            $(".select-query").show();
            var str="";
            $(result).each(function(index,value)
            {
                str=str+"<a href='javascript:void(0)' class='res list-group-item list-group-item-action'>"+value.provience+" ---- "+value.city+"</a>";
            });
            $(".select-query").html(str);
        },"json");
    }
}






