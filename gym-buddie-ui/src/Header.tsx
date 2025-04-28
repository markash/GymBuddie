export default function Header() {
  const menu = ["About", "Services", "Products"];

  return (
    <header>
      <div className="container-fluid">
        <nav>
          <hgroup>
            <h1 className="app-title">Gym Buddie</h1>
            <h3>Lorem ipsum for some really awesome application</h3>
          </hgroup>
          <ul>
            {menu.map((item) => (
              <li key={item}>
                <a href="#">{item}</a>
              </li>
            ))}
          </ul>
        </nav>
      </div>
    </header>
  );
}
