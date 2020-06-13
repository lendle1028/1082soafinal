<%-- 
    Document   : list
    Created on : Jun 1, 2019, 3:18:36 PM
    Author     : lendle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-image: url('run4food.png');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-position: right;
            }
        </style>
        <script
            src="https://code.jquery.com/jquery-3.3.1.js"
        ></script>
        <script src="https://cdn.jsdelivr.net/npm/vue@2.6.7/dist/vue.js"></script>
        <script>
            var v = null;
            $(document).ready(function () {
                $.ajax("webapi/foods", {
                    success: function (foods) {
                        v = new Vue({
                            el: "#foods",
                            data: {
                                "foods": foods
                            },
                            methods: {
                                edit: function (food) {
                                    window.location.href = "editFood.jsp?id=" + food.id;
                                },
                                remove: function (food) {
                                    $.ajax("webapi/food/" + food.id, {
                                        type: "DELETE",
                                        success: function () {
                                            window.location.href = "list.jsp";
                                        },
                                        error: function () {
                                            alert("failed");
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            });
            function addFood() {
                window.location.href = "addFood.jsp";
            }
        </script>
    </head>
    <body>
        <h3>蠟筆小新的美食筆記 （Crayon Shinchan's Favorite Food List）</h3>
        <button onclick="addFood();">NEW</button>
        <div id="foods">
            <table border="1" style="width: 90%">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="food in foods">
                        <td>{{food.id}}</td>
                        <td>{{food.name}}</td>
                        <td>{{food.price}}</td>
                        <td>{{food.description}}</td>
                        <td><button v-on:click="edit(food);">EDIT</button>
                            <button v-on:click="remove(food);">DELETE</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
