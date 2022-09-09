import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

import Navbar from './Components/Navbar/Navbar';
import Landing from './Components/Landing/Landing';

function App() {
  return (
    <div className="App">
      <Navbar />
      <Landing />
    </div>
  );
}

export default App;
