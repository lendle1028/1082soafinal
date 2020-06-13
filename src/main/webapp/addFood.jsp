<%-- 
    Document   : addFood
    Created on : Jun 1, 2019, 8:37:38 PM
    Author     : lendle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script
            src="https://code.jquery.com/jquery-3.3.1.js"
        ></script>
        <script src="https://cdn.jsdelivr.net/npm/vue@2.6.7/dist/vue.js"></script>
        <script>
            var v = null;
            $(document).ready(function () {
                v = new Vue({
                    el: "#food",
                    data: {
                        food: {
                            id: -1,
                            name: "",
                            price: "",
                            description: ""
                        }
                    },
                    methods: {
                        save: function (food) {
                            $.ajax("webapi/food", {
                                type: "POST",
                                contentType: "application/json",
                                data: JSON.stringify(food),
                                success: function () {
                                    window.location.href = "list.jsp";
                                },
                                error: function () {
                                    alert("fail!");
                                }
                            });
                        }
                    }
                });
                
            });
        </script>
    </head>
    <body>
        <div id="food">
            Name: <input type="text" v-model="food.name"/><br/>
            price: <input type="text" v-model="food.price"/><br/>
            Content:<br/>
            <textarea v-model="food.description"></textarea>
            <button v-on:click="save(food);">SAVE</button>
        </div>
    </body>
</html>

