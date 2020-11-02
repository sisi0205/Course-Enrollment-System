import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import NavBar from './components/NavBar';
import AllCourses from './views/AllCourses';
import EnrolledCourses from './views/EnrolledCourses';
import LoginDialog from "./components/login/LoginDialog";

export default function App() {
  return (
    <Router>
      <div>
        <NavBar />
        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        {/* switch render different */}
        {/* save switch component into views */}
        <Switch>
          {/*virtual page and single page*/}
          <Route path="/enrolled-courses">
            <EnrolledCourses />
          </Route>
          <Route path = "/debug">
            <LoginDialog />
          </Route>
          <Route path="/">
            <AllCourses />
          </Route>

        </Switch>
      </div>
    </Router>
  );
}
