require 'test_helper'

class ConfigurationsControllerTest < ActionController::TestCase
  def test_should_get_index
    get :index
    assert_response :success
    assert_not_nil assigns(:configurations)
  end

  def test_should_get_new
    get :new
    assert_response :success
  end

  def test_should_create_configuration
    assert_difference('Configuration.count') do
      post :create, :configuration => { }
    end

    assert_redirected_to configuration_path(assigns(:configuration))
  end

  def test_should_show_configuration
    get :show, :id => configurations(:one).id
    assert_response :success
  end

  def test_should_get_edit
    get :edit, :id => configurations(:one).id
    assert_response :success
  end

  def test_should_update_configuration
    put :update, :id => configurations(:one).id, :configuration => { }
    assert_redirected_to configuration_path(assigns(:configuration))
  end

  def test_should_destroy_configuration
    assert_difference('Configuration.count', -1) do
      delete :destroy, :id => configurations(:one).id
    end

    assert_redirected_to configurations_path
  end
end
