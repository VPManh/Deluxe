<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Login</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #74ebd5 0%, #ACB6E5 100%);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: #ffffff;
            padding: 30px 50px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 100%;
            max-width: 400px;
        }

        h2 {
            margin-bottom: 25px;
            color: #333;
            font-size: 28px;
            font-weight: bold;
        }

        .input-group {
            margin-bottom: 20px;
            text-align: left;
        }

        .input-group label {
            display: block;
            margin-bottom: 8px;
            color: #666;
            font-size: 14px;
            font-weight: bold;
        }

        .input-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
            color: #333;
        }

        .input-group input:focus {
            border-color: #007BFF;
            outline: none;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .login-btn {
            width: 100%;
            padding: 12px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .login-btn:hover {
            background-color: #0056b3;
        }

        #error-message {
            color: red;
            margin-top: 15px;
            text-align: center;
        }

        @media (max-width: 500px) {
            .login-container {
                padding: 20px;
            }

            h2 {
                font-size: 24px;
            }

            .input-group input {
                font-size: 14px;
            }

            .login-btn {
                padding: 10px;
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login to Hotel</h2>
    <form id="loginForm" onsubmit="return validateForm()"
          method="post" action="/login">
        <c:if test="${param.error != null}">
            <div class="my-2" style="color: red;">email hoặc password không lệ.</div>
        </c:if>

        <div class="input-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="input-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <button type="submit" class="login-btn">Login</button>
    </form>
    <div id="error-message"></div>
</div>
<script>
    function validateForm() {
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;
        var errorMessage = document.getElementById('error-message');

        if (username === "" || password === "") {
            errorMessage.textContent = "Please fill out all fields.";
            return false;
        }
        return true;
    }
</script>
</body>
</html>
