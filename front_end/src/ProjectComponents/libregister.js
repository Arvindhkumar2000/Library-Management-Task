import React from "react";
import './libregister.css';

export function  Libregister(){

    return(
        <>
        <div class="container">
    <div class="row">
      <div class="col-md-6 mx-auto">
        <div class="registration-form">
          <h2 class="mb-3">Registration Form</h2>
          <form>
            <div class="mb-3">
              <label for="username" class="form-label">Username</label>
              <input type="text" class="form-control" id="username" name="username" required/>
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">Email</label>
              <input type="email" class="form-control" id="email" name="email" required/>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Password</label>
              <input type="password" class="form-control" id="password" name="password" required/>
            </div>
            <div class="mb-3">
              <label for="confirm-password" class="form-label">Confirm Password</label>
              <input type="password" class="form-control" id="confirm-password" name="confirm-password" required/>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
          </form>
        </div>
      </div>
    </div>
  </div>
        </>
    );

}