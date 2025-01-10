import Header from "./components/layout/Header.tsx";
import './components/layout/layout.css';
import './App.css';
import HomePage from "./pages/Home.tsx";
import Footer from "./components/layout/Footer.tsx";

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