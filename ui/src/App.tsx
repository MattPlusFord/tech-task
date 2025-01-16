import Header from "./components/layout/Header";
import './components/layout/layout.css';
import './App.css';
import HomePage from "./pages/Home";
import Footer from "./components/layout/Footer";
import {BrowserRouter} from "react-router-dom";

export const App = () => {
    return (
        <>
            <Header />
            <main data-testid={'main-wrapper'} className="main">
                <BrowserRouter>
                    <HomePage />
                </BrowserRouter>
            </main>
            <Footer />
        </>
    )
}

export default App;