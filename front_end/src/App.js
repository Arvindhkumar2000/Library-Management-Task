import logo from './logo.svg';
import './App.css';
import { Library } from './ProjectComponents/library';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import { Libregister } from './ProjectComponents/libregister';

function App() {
  return (
    <>
    <BrowserRouter>
     <Routes>
      <Route path ='/' element ={[<Library/>]}></Route>
      <Route path ='/libregistration' element={[<Libregister/>]}></Route>
     </Routes>

    </BrowserRouter>
    </>
  );
}

export default App;
