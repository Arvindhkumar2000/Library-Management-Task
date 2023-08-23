import React from "react";
import './library.css';
import { Link } from "react-router-dom";


export function Library(){

    return(

        <>
         <div class="container body">
            <h2 class="text-center">LIBRARY</h2>
    <div class="login-container">
     
      <form>
        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" class="form-control" id="username" placeholder="Enter username"/>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" placeholder="Password"/>
        </div>
        <button type="submit" class=" w-100 mt-3 but">Login</button>

        <p class ="mt-5">Not an Existing User? <Link to="/libregistration" ><span>Signup</span></Link> </p>
      </form>
    </div>
  </div>
        </>
    );
}