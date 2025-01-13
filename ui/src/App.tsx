import Header from "./components/layout/Header";
import './components/layout/layout.css';
import './App.css';
import HomePage from "./pages/Home";
import Footer from "./components/layout/Footer";

export const App = () => {
    return (
        <>
            <Header />
            <main className="main">
                <HomePage />
            </main>
            <Footer />
        </>
    )
}

export default App;